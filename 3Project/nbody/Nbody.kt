/**
 * file: Nbody.kt
 *
 * @author: Jacob Albers
 */

import processing.core.*
import ddf.minim.*

const val GRAVITATIONAL_CONSTANT = 6.67e-11 // gravitational constant
const val deltaT = 25000.0 // time quantum

const val resources = "src/resources"
const val backgroundImageFile = "$resources/starfield.jpg"
const val musicFile = "$resources/2001.wav"

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
	java.util.Scanner(java.io.FileReader(args[0])).use { scanner ->
	n = scanner.nextInt()
	radius = scanner.nextDouble()
	px = DoubleArray(n){0.0}
	py = DoubleArray(n){0.0}
	vx = DoubleArray(n){0.0}
	vy = DoubleArray(n){0.0}
	mass = DoubleArray(n){0.0}
	bodyName = Array<String>(n, {""})
	for (i in 0..n-1){
		px[i] = (scanner.nextDouble())
		py[i] = (scanner.nextDouble())
		vx[i] = (scanner.nextDouble())
		vy[i] = (scanner.nextDouble())
		mass[i] = (scanner.nextDouble())
		bodyName[i] = "$resources/${scanner.next()}"
	}

}
    /* now calls the main method of your PApplet class */
    PApplet.main("NbodyPApplet")
}

class NbodyPApplet : PApplet() {
	val body = arrayOfNulls<PImage>(n)
	val fx = DoubleArray(n){0.0}
	val fy = DoubleArray(n){0.0}
	val ax = DoubleArray(n){0.0}
	val ay = DoubleArray(n){0.0}
	lateinit var bg : PImage
	
    override fun settings() {
        size(512, 512)
    }

    override fun setup() {
		val minim = Minim(this)
		val music = minim.loadFile(musicFile)
		music.play()
		bg = loadImage(backgroundImageFile)
		for (i in 0..n-1){
			body[i] = loadImage(bodyName[i])
		}
    }

    override fun draw() {
		background(bg)
		translate(width/2f, height/2f)
		updateForce()
		updateAcceleration()
		updateVelocity()
		updatePosition()
		for (i in 0..n-1){
			val img = body[i]
			image(img, (width / radius * px[i] / 2).toFloat(), (height / radius * py[i] / 2).toFloat())
		}
		translate(-width/2f, -height/2f)
    }
	
	fun updateForce(){
		for (i in 0..n-1){
			fx[i] = 0.0
			fy[i] = 0.0
			for (j in 0..n-1){
				if (i != j){
					val deltaX = px[j] - px[i]
					val deltaY = py[j] - py[i]
					val r = kotlin.math.sqrt(deltaX*deltaX + deltaY*deltaY)
					val gravF = (GRAVITATIONAL_CONSTANT*mass[i]*mass[j])/(r*r)
					fx[i] += ((gravF*(deltaX/r)))
					fy[i] += ((gravF*(deltaY/r)))
				}
			}
		}
	}
	
	fun updateAcceleration(){
		for (i in 0..n-1){
			ax[i] = fx[i] / mass[i]
			ay[i] = fy[i] / mass[i]
		}
	}
	
	fun updateVelocity(){
		for (i in 0..n-1){
			vx[i] = vx[i] + deltaT*ax[i]
			vy[i] = vy[i] + deltaT*ay[i]
		}
	}
	
	fun updatePosition(){
		for (i in 0..n-1){
			px[i] = px[i] + deltaT*vx[i]
			py[i] = py[i] + deltaT*vy[i]
		}
	}		
}
