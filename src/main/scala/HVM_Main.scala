import atmospheric.AirComposition
import org.bionic.BionicH
import org.bionic.system.nervous.central.Medulla

import scala.io.StdIn

/**
 * Start Bionic Virtual Machine Main APP Object
 *
 *
 */
object HVM_Main extends App {


    println("Hello, geeks!")
    println("Starting the BionicScala life...")

    var airDry = AirComposition.airDry(0)

    var bionic = new BionicH(airDry)
    bionic.start()
    //bionic.air = airDry

    var ok = true
    while(ok){

        val s = StdIn.readLine("Put command")

        if( s == "air"){
            print("Put value altittude")
            val alttitude = StdIn.readInt()
            //airDry = AirComposition.airDry(alttitude)
            airDry.pO2 = alttitude
            //println(airDry)
        } else if ( s == "q") {
            ok = false
        }

    }
/*
    // Use an infinite loop.
    while (true) {

        // Read a line from the console window.
        val line = scala.io.StdIn.readLine()

        // Write the result string and a newline.
        printf("You typed: %s", line)
        println()
    }

*/





}
