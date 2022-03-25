package Node

//Class to match varied Opcodes to their function. Returns code in python as string
class LookUp
{
    //Function to match Opcodes. Takes a string Opcode
    fun match(Opcode: String): String
    {
        //Declaring variables for parsing data and relevant patterns
        var str: String = Opcode
        var str0: String = ""
        var str1: String = ""
        var str2: String = ""
        var str3: String = ""
        var str4: String = ""
        var str5: String = ""
        var code: String = ""
        val pat1 = Regex(pattern = "B+[A-L[N]]")
        val pat2 = Regex(pattern = "AA+[A-Z]+[;]")
        val pat3 = Regex(pattern = "SS+[;]|XX+[;]")
        val pat4 = Regex(pattern = "C+[A-G[I-L][O-Q]]+[(]")
        val pat5 = Regex(pattern = "CS+[0-9]+[0-9]+[0-9]+[0-9]+[(]")
        //var result = pat1.containsMatchIn(str)

        //Checks whether the first pattern has a match in the string
        if(pat1.containsMatchIn(str))
        {
            //Declaring variables to match sub-patterns
            val bpat1 = Regex(pattern = "^A+[(]")
            val bpat2 = Regex(pattern = "^B+[(]")
            val bpat3 = Regex(pattern = "^C+[(]")
            val bpat4 = Regex(pattern = "^D+[(]")
            val bpat5 = Regex(pattern = "^E+[(]")
            val bpat6 = Regex(pattern = "^F+[(]")
            val bpat7 = Regex(pattern = "^G+[(]")
            val bpat8 = Regex(pattern = "^H+[(]")
            val bpat9 = Regex(pattern = "^I+[(]")
            val bpat10 = Regex(pattern = "^J+[(]")
            val bpat11 = Regex(pattern = "^K+[(]")
            val bpat12 = Regex(pattern = "^L+[(]")
            val bpat13 = Regex(pattern = "^N+[(]")

            //Removes initial letter of string to simplify further pattern matching
            str0 = str.substringAfter("B")

            print("Found pat1\n")

            //Checks whether 1st sub-pattern has a match
            if(bpat1.containsMatchIn(str0))
            {
                print("Found bpat1\n")
                //Parses data into several strings
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore("=")
                str3 = str1.substringAfter("=")
                str4 = str3.substringBefore(")")
                //Final code is stored as python code
                str5 = "$str2 + $str4\n"
            }

            //Checks whether 2nd sub-pattern has a match
            if(bpat2.containsMatchIn(str0))
            {
                print("Found bpat2\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore("=")
                str3 = str1.substringAfter("=")
                str4 = str3.substringBefore(")")
                //Final code is stored as python code
                str5 = "$str2 - $str4\n"
            }

            //Checks whether 3rd sub-pattern has a match
            if(bpat3.containsMatchIn(str0))
            {
                print("Found bpat3\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore("=")
                str3 = str1.substringAfter("=")
                str4 = str3.substringBefore(")")
                //Final code is stored as python code
                str5 = "$str2 * $str4\n"
            }

            //Checks whether 4th sub-pattern has a match
            if(bpat4.containsMatchIn(str0))
            {
                print("Found bpat4\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore("=")
                str3 = str1.substringAfter("=")
                str4 = str3.substringBefore(")")
                //Final code is stored as python code
                str5 = "$str2 / $str4\n"
            }

            //Checks whether 5th sub-pattern has a match
            if(bpat5.containsMatchIn(str0))
            {
                print("Found bpat5\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore("=")
                str3 = str1.substringAfter("=")
                str4 = str3.substringBefore(")")
                //Final code is stored as python code
                str5 = "($str2 == $str4):\n\t"
            }

            //Checks whether 6th sub-pattern has a match
            if(bpat6.containsMatchIn(str0))
            {
                print("Found bpat6\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore("=")
                str3 = str1.substringAfter("=")
                str4 = str3.substringBefore(")")
                //Final code is stored as python code
                str5 = "($str2 != $str4):\n\t"
            }

            //Checks whether 7th sub-pattern has a match
            if(bpat7.containsMatchIn(str0))
            {
                print("Found bpat7\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore("=")
                str3 = str1.substringAfter("=")
                str4 = str3.substringBefore(")")
                //Final code is stored as python code
                str5 = "($str2 > $str4):\n\t"
            }

            //Checks whether 8th sub-pattern has a match
            if(bpat8.containsMatchIn(str0))
            {
                print("Found bpat8\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore("=")
                str3 = str1.substringAfter("=")
                str4 = str3.substringBefore(")")
                //Final code is stored as python code
                str5 = "($str2 >= $str4):\n\t"
            }

            //Checks whether 9th sub-pattern has a match
            if(bpat9.containsMatchIn(str0))
            {
                print("Found bpat9\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore("=")
                str3 = str1.substringAfter("=")
                str4 = str3.substringBefore(")")
                //Final code is stored as python code
                str5 = "$str2 && $str4\n"
            }

            //Checks whether 10th sub-pattern has a match
            if(bpat10.containsMatchIn(str0))
            {
                print("Found bpat10\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore("=")
                str3 = str1.substringAfter("=")
                str4 = str3.substringBefore(")")
                //Final code is stored as python code
                str5 = "$str2 || $str4\n"
            }

            //Checks whether 11th sub-pattern has a match
            if(bpat11.containsMatchIn(str0))
            {
                print("Found bpat11\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore("=")
                str3 = str1.substringAfter("=")
                str4 = str3.substringBefore(")")
                //Final code is stored as python code
                str5 = "math.pow($str2, $str4)\n"
            }

            //Checks whether 12th sub-pattern has a match
            if(bpat12.containsMatchIn(str0))
            {
                print("Found bpat12\n")
                //Since there are two motors two patterns are created to match the specific motor
                val blpat1 = Regex(pattern = "^=A")
                val blpat2 = Regex(pattern = "^=B")
                var sstr: String = ""
                sstr = str0.substringAfter("L(")
                println(sstr)

                //Checks whether 1st pattern has a match
                if(blpat1.containsMatchIn(sstr))
                {
                    str1 = sstr.substringAfter("=")
                    str2 = str1.substringBefore("=")
                    str3 = str1.substringAfter("=")
                    str4 = str3.substringBefore(")")
                    //Final code is stored as python code
                    str5 = "motor1.run($str4)\n\t"
                }

                //Checks whether 1st pattern has a match
                if(blpat2.containsMatchIn(sstr))
                {
                    str1 = sstr.substringAfter("=")
                    str2 = str1.substringBefore("=")
                    str3 = str1.substringAfter("=")
                    str4 = str3.substringBefore(")")
                    //Final code is stored as python code
                    str5 = "motor2.run($str4)\n"
                }
            }
            //Checks whether 13th sub-pattern has a match
            if(bpat13.containsMatchIn(str0))
            {
                print("Found bpat13\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore("=")
                str3 = str1.substringAfter("=")
                str4 = str3.substringBefore(")")
                //Final code is stored as python code
                str5 = "$str2 = $str4\n"
            }
        }

        //Checks whether 2nd pattern has a match
        if(pat2.containsMatchIn(str))
        {
            str1 = str.substringAfterLast("A")
            str2 = str1.substringBefore(";")
            //Final code is stored as python code
            str3 = "$str2 = random.seed(21)\n"
        }

        //Checks whether 3rd pattern has a match
        if(pat3.containsMatchIn(str))
        {
            //Start Opcode is special and has no variations
            if(str == "SS;")
            {
                //Final code is stored as python code
                str5 = "#!/usr/bin/env pybricks-micropython\n" +
                        "from pybricks.hubs import EV3Brick\n" +
                        "from pybricks.ev3devices import (Motor, TouchSensor, ColorSensor,InfraredSensor, UltrasonicSensor, GyroSensor)\n" +
                        "from pybricks.parameters import Port, Stop, Direction, Button, Color\n" +
                        "from pybricks.tools import wait, StopWatch, DataLog\n" +
                        "from pybricks.robotics import DriveBase\n" +
                        "from pybricks.media.ev3dev import SoundFile, ImageFile\n" +
                        "import math\n" +
                        "motor1 = Motor(Port.B)\n" +
                        "motor2 = Motor(Port.C)\n"
            }

            //Stop Opcode is special and has no variations
            if(str == "XX;")
            {
                //Final code is stored as python code
                str5 = "#Program Terminates\n"
            }
        }

        //Checks whether 4th pattern has a match
        if(pat4.containsMatchIn(str))
        {
            //Declaring variables to match sub-patterns
            val cpat1 = Regex(pattern = "^A+[(]")
            val cpat2 = Regex(pattern = "^B+[(]")
            val cpat3 = Regex(pattern = "^C+[(]")
            val cpat4 = Regex(pattern = "^D+[(]")
            val cpat5 = Regex(pattern = "^E+[(]")
            val cpat6 = Regex(pattern = "^F+[(]")
            val cpat7 = Regex(pattern = "^G+[(]")
            val cpat8 = Regex(pattern = "^I+[(]")
            val cpat9 = Regex(pattern = "^J+[(]")
            val cpat10 = Regex(pattern = "^K+[(]")
            val cpat11 = Regex(pattern = "^L+[(]")
            val cpat12 = Regex(pattern = "^O+[(]")
            val cpat13 = Regex(pattern = "^P+[(]")
            val cpat14 = Regex(pattern = "^Q+[(]")

            print("Found pat4\n")
            //Removes initial letter of string to simplify further pattern matching
            str0 = str.substringAfter("C")

            //Checks whether 1st sub-pattern has a match
            if(cpat1.containsMatchIn(str0))
            {
                print("Found cpat1\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore(")")
                str3 = str0.substringAfter(")")
                str4 = str3.substringBefore(";")
                //Final code is stored as python code
                str5 = "$str4 = not $str2\n"

            }

            //Checks whether 2nd sub-pattern has a match
            if(cpat2.containsMatchIn(str0))
            {
                print("Found cpat2\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore(")")
                str3 = str0.substringAfter(")")
                str4 = str3.substringBefore(";")
                //Final code is stored as python code
                str5 = "$str4 = -$str2\n"
            }

            //Checks whether 3rd sub-pattern has a match
            if(cpat3.containsMatchIn(str0))
            {
                print("Found cpat3\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore(")")
                str3 = str0.substringAfter(")")
                str4 = str3.substringBefore(";")
                //Final code is stored as python code
                str5 = "$str4 = math.sqrt($str2)\n"
            }

            //Checks whether 4th sub-pattern has a match
            if(cpat4.containsMatchIn(str0))
            {
                print("Found cpat4\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore(")")
                str3 = str0.substringAfter(")")
                str4 = str3.substringBefore(";")
                //Final code is stored as python code
                str5 = "$str4 = math.trunc($str2)\n"
            }

            //Checks whether 5th sub-pattern has a match
            if(cpat5.containsMatchIn(str0))
            {
                print("Found cpat5\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore(")")
                str3 = str0.substringAfter(")")
                str4 = str3.substringBefore(";")
                //Final code is stored as python code
                str5 = "$str4 = math.ceil($str2)\n"
            }

            //Checks whether 6th sub-pattern has a match
            if(cpat6.containsMatchIn(str0))
            {
                print("Found cpat6\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore(")")
                str3 = str0.substringAfter(")")
                str4 = str3.substringBefore(";")
                //Final code is stored as python code
                str5 = "$str4 = math.floor($str2)\n"
            }

            //Checks whether 7th sub-pattern has a match
            if(cpat7.containsMatchIn(str0))
            {
                print("Found cpat7\n")
                if(str0 == "G(=A);")
                {
                    //Final code is stored as python code
                    str5 = "motor1.stop()\n"
                }
                if(str0 == "G(=B);")
                {
                    //Final code is stored as python code
                    str5 = "motor2.stop()\n"
                }
            }

            //Checks whether 8th sub-pattern has a match
            if(cpat8.containsMatchIn(str0))
            {
                val cipat1 = Regex(pattern = "^I+[(]+[=]+[A]")
                val cipat2 = Regex(pattern = "^I+[(]+[=]+[B]")
                val cipat3 = Regex(pattern = "^I+[(]+[=]+[C]")
                print("Found cpat8\n")
                if(cipat1.containsMatchIn(str0))
                {
                    print("Found cipat1\n")
                    str1 = str0.substringAfter("=")
                    str2 = str1.substringBefore(")")
                    str3 = str0.substringAfter(")")
                    str4 = str3.substringBefore(";")
                    //Final code is stored as python code
                    str5 = "$str4 = touch_sensor1.pressed()\n"
                }
                if(cipat2.containsMatchIn(str0))
                {
                    print("Found cipat2\n")
                    str1 = str0.substringAfter("=")
                    str2 = str1.substringBefore(")")
                    str3 = str0.substringAfter(")")
                    str4 = str3.substringBefore(";")
                    //Final code is stored as python code
                    str5 = "$str4 = touch_sensor2.pressed()\n"
                }
                if(cipat3.containsMatchIn(str0))
                {
                    print("Found cipat3\n")
                    print("No Touch Sensor Configured")
                }
            }

            //Checks whether 9th sub-pattern has a match
            if(cpat9.containsMatchIn(str0))//Not Sure How To Implement This Button Release
            {
                val cipat4 = Regex(pattern = "^J+[(]+[=]+[A]")
                val cipat5 = Regex(pattern = "^J+[(]+[=]+[B]")
                val cipat6 = Regex(pattern = "^J+[(]+[=]+[C]")
                print("Found cpat9\n")
                if(cipat4.containsMatchIn(str0))
                {
                    print("Found cipat4\n")
                }
                if(cipat5.containsMatchIn(str0))
                {
                    print("Found cipat5\n")
                }
                if(cipat6.containsMatchIn(str0))
                {
                    print("Found cipat6\n")
                }

            }

            //Checks whether 10th sub-pattern has a match
            if(cpat10.containsMatchIn(str0))//Not Sure How To Implement This LED On
            {
                val cipat7 = Regex(pattern = "^K+[(]+[=]+[A]")
                val cipat8 = Regex(pattern = "^K+[(]+[=]+[B]")
                val cipat9 = Regex(pattern = "^K+[(]+[=]+[C]")
                print("Found cpat10\n")
                if(cipat7.containsMatchIn(str0))
                {
                    print("Found cipat7\n")
                }
                if(cipat8.containsMatchIn(str0))
                {
                    print("Found cipat8\n")
                }
                if(cipat9.containsMatchIn(str0))
                {
                    print("Found cipat9\n")
                }
            }

            //Checks whether 11th sub-pattern has a match
            if(cpat11.containsMatchIn(str0))//Not Sure How To Implement This LED Off
            {
                val cipat10 = Regex(pattern = "^L+[(]+[=]+[A]")
                val cipat11 = Regex(pattern = "^L+[(]+[=]+[B]")
                val cipat12 = Regex(pattern = "^L+[(]+[=]+[C]")
                print("Found cpat11\n")
                if(cipat10.containsMatchIn(str0))
                {
                    print("Found cipat10\n")
                }
                if(cipat11.containsMatchIn(str0))
                {
                    print("Found cipat11\n")
                }
                if(cipat12.containsMatchIn(str0))
                {
                    print("Found cipat12\n")
                }
            }

            //Checks whether 12th sub-pattern has a match
            if(cpat12.containsMatchIn(str0))
            {
                print("Found cpat12\n")
                if(str0 == "O(=A)Y;")
                {
                    str1 = str0.substringAfter("=")
                    str2 = str1.substringBefore(")")
                    str3 = str0.substringAfter(")")
                    str4 = str3.substringBefore(";")
                    //Final code is stored as python code
                    str5 = "$str4 = light_sensor.ambient()\n"
                }
            }

            //Checks whether 13th sub-pattern has a match
            if(cpat13.containsMatchIn(str0))//Light Sensor Off?
            {
                print("Found cpat13\n")
            }

            //Checks whether 14th sub-pattern has a match
            if(cpat14.containsMatchIn(str0))
            {
                print("Found cpat14\n")
                str1 = str0.substringAfter("=")
                str2 = str1.substringBefore(")")
                str3 = str0.substringAfter(")")
                str4 = str3.substringBefore(";")
                //Final code is stored as python code
                str5 = "wait($str2)\n"

            }

        }

        //Checks whether 5th pattern has a match
        if(pat5.containsMatchIn(str))//Matching for the if statement opcode
        {
            print("Found pat5\n")
            //Final code is stored as python code
            str5 = "if "
        }
        else
        {
            print("Not Found\n")
        }

        //println(result)
        println(str0)
        println(str1)
        println(str2)
        println(str3)
        println(str4)
        println(str5)
        code = str5


        //Returns the string containing the python code
        return code

    }

}