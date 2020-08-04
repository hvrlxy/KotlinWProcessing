/**
 * file: Nbody.kt
 *
 * @author: HA LE
 */

import processing.core.*
import ddf.minim.*
import java.util.Scanner
import java.io.FileReader
import kotlin.math.*


const val GRAVITATIONAL_CONSTANT = 6.67e-11 // gravitational constant
var deltaT = 25000.0 // time quantum

const val resources = "src/resources"
const val backgroundImageFile = "$resources/spacepic.jpg"
const val musicFile = "$resources/st.mp3"

var n = 0 // number of bodies
var radius = 0.0 // radius of the universe
lateinit var px: DoubleArray // x-coord's of initial positions
lateinit var py: DoubleArray // y-coord's of initial positions
lateinit var vx: DoubleArray // initial velocities along x-axis
lateinit var vy: DoubleArray // initial velocities along y-axis
lateinit var mass: DoubleArray // masses
lateinit var bodyName: Array<String> // names of bodies

lateinit var pairForceXArray: DoubleArray
lateinit var pairForceYArray: DoubleArray

fun main(args: Array<String>) {
    /* write code to open input file and read in all data here */
    if (args.isEmpty()){
        println("Please provide a file")
        System.exit(-1)
    }
    val file = java.io.FileReader(args[0])
    val scanner = java.util.Scanner(file)
    n = scanner.nextInt()
    radius = scanner.nextDouble()
    px = DoubleArray(n){0.0}
    py = DoubleArray(n){0.0}
    vx = DoubleArray(n){0.0}
    vy = DoubleArray(n){0.0}
    mass = DoubleArray(n){0.0}
    bodyName = Array<String>(n) {""}

    pairForceXArray = DoubleArray(n){0.0}
    pairForceYArray = DoubleArray(n){0.0}

    for (i in 0 until n){
        px[i] = scanner.nextDouble()
        py[i] = scanner.nextDouble()
        vx[i] = scanner.nextDouble()
        vy[i] = scanner.nextDouble()
        mass[i] = scanner.nextDouble()
        bodyName[i] = "$resources/${scanner.next()}"
    }

    for (i in 0 until n){
        vy[i] = -vy[i]
    }

        /* now calls the main method of your PApplet class */
    PApplet.main("NbodyPApplet")
}

class NbodyPApplet : PApplet() {
    var body = arrayOfNulls<PImage>(n)
    lateinit var bg: PImage
    override fun settings() {
        size(1280,804) //size of the picture
    }

    override fun setup() {
        val minim = Minim(this)
        val music = minim.loadFile(musicFile)
        music.play()


        translate((width/2).toFloat(),(height/2).toFloat())

        bg = loadImage(backgroundImageFile)

        for (i in 0 until n){
            body[i] = loadImage(bodyName[i])
        }
    }

    
    override fun draw() {
        background(bg)
        translate((width/2).toFloat(),(height/2).toFloat())
        for (i in 0 until n ){

            for (j in 0 until n){
                if (j != i){
                    var ijX = pairForceX(px[i],py[i],px[j],py[j], mass[i], mass[j])
                    var ijY = pairForceY(px[i],py[i],px[j],py[j], mass[i], mass[j])
                    pairForceXArray[j] = ijX
                    pairForceYArray[j] = ijY
                }
                else{
                    pairForceXArray[j] = 0.0
                    pairForceYArray[j] = 0.0
                }
            }
            var nFX = netForceX(pairForceXArray)
            var nFY = netForceY(pairForceYArray)

            var accX = accelerationX(nFX,mass[i])
            var accY = accelerationY(nFY,mass[i])

            vx[i] = newVelocitiesX(vx[i],accX)
            vy[i] = newVelocitiesY(vy[i],accY)

            px[i] = newPositionX(px[i],vx[i])
            py[i] = newVelocitiesY(py[i],vy[i])
            
            image(body[i], (px[i]/radius * width/2).toFloat(), (py[i]/radius * height/2).toFloat())
        }

        translate((-width/2).toFloat(),(-height/2).toFloat())
    }

    /* Functions used to calculate the forces, velocities and the new positions */
    fun pairForceX (x: Double, y: Double, x1: Double, y1:Double, mass: Double, mass1: Double): Double{
        var deltaX = x1 - x
        var deltaY = y1 - y
        var r = sqrt(deltaX.pow(2)+deltaY.pow(2))
        var cosa = deltaX/r
        var pairForce = (GRAVITATIONAL_CONSTANT*mass*mass1/(deltaX.pow(2)+deltaY.pow(2)))
        var pairForceX = pairForce * cosa

        return (pairForceX)
    }

    fun pairForceY (x: Double, y: Double, x1: Double, y1:Double, mass: Double, mass1: Double): Double{
        var deltaX = x1 - x
        var deltaY = y1 - y
        var r = sqrt(deltaX.pow(2)+deltaY.pow(2))
        var sina = deltaY/r
        var pairForce = (GRAVITATIONAL_CONSTANT*mass*mass1/(deltaX.pow(2)+deltaY.pow(2)))
        var pairForceY = pairForce * sina

        return (pairForceY)
    }

    fun netForceX (x: DoubleArray): Double{
        var netForceX = x.sum()
        return (netForceX)
    }

    fun netForceY (x: DoubleArray): Double{
        var netForceY = x.sum()
        return (netForceY)
    }

    fun accelerationX(netForceX: Double, Mass: Double): Double{
        var accelerationX = netForceX/Mass
        return accelerationX
    }

    fun accelerationY(netForceY: Double, Mass: Double): Double{
        var accelerationY = netForceY/Mass
        return accelerationY
    }

    fun newVelocitiesX(vx: Double, ax: Double): Double{
        var newVelocitiesX = vx + ax*deltaT
        return newVelocitiesX
    }

    fun newVelocitiesY(vy: Double, ay: Double): Double{
        // Use - instead of + to translate the Cartesian Coordinate to the processing coordinate
        var newVelocitiesY = vy - ay*deltaT
        return newVelocitiesY
    }

    fun newPositionX(px: Double, newVelocitiesX: Double): Double{
        var newPositionX = px + newVelocitiesX * (deltaT)
        return (newPositionX)
    }

    fun newPositionY(py: Double, newVelocitiesY: Double): Double{
        var newPositionY = py + newVelocitiesY * (deltaT)
        return (newPositionY)
    }
}

