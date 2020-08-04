/**
 * file: Nbody.kt
 *
 * @author: YOUR NAME HERE
 */

import processing.core.*
//import ddf.minim.*

const val GRAVITATIONAL_CONSTANT = 6.67e-11 // gravitational constant
const val deltaT = 25000.0 // time quantum

const val resources = "src/resources"
//const val backgroundImageFile = "$resources/starfield.jpg"
//const val musicFile = "$resources/2001.wav"

var n = 0 // number of bodies
var radius = 0.0 // radius of the universe
lateinit var px: DoubleArray // x-coord's of initial positions
lateinit var py: DoubleArray // y-coord's of initial positions
lateinit var vx: DoubleArray // initial velocities along x-axis
lateinit var vy: DoubleArray // initial velocities along y-axis
lateinit var mass: DoubleArray // masses
lateinit var bodyName: Array<String> // names of bodies

fun main(args: Array<String>) {
    /* write code to open input file and read in all data here */
    val file = java.io.FileReader(args[0])
    val scanner = java.util.Scanner(file)

    // read the number of bodies and universe radius 
    val n = scanner.nextInt()
    val radius = scanner.next()

    // initialize four parallel arrays
    val posX = DoubleArray(n)
    val posY = DoubleArray(n)
    val velX = DoubleArray(n)
    val velY = DoubleArray(n)
    val mass = DoubleArray(n)
    val name = Array<String>(n) { "" }

    // read in the data
    for (i in 0 until n) {
        posX[i] = scanner.nextDouble()
        posY[i] = scanner.nextDouble()
        velX[i] = scanner.nextDouble()
        velY[i] = scanner.nextDouble()
        mass[i] = scanner.nextDouble()
        name[i] = "$resources/${scanner.next()}"
    }

    // print login names of all students in section 3
    println(n)
    println(radius)

    println("""Body Names
              |---------
        """.trimMargin())
    for (i in 0 until n) {
        println(name[i])
    }
    scanner.close()
    file.close()
    /* now calls the main method of your PApplet class */
    PApplet.main("NbodyPApplet")
}

class NbodyPApplet : PApplet() {

    override fun settings() {
        size(512, 512)
    }

    // override fun setup() {
    // }

    // override fun draw() {
    // }
}
