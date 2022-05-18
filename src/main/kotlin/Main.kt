import java.util.*
import java.util.logging.Handler
import kotlin.concurrent.schedule

fun main(args: Array<String>) {
    var mainClass: Main =  Main()

    Main.main()
}

class Main {

    interface CallBackInterface{
        fun printHello()
    }

    companion object {
        var name : String = "PDF Converter"
        fun main () {
            // This is the anonymous call, we do via the object
            // hence below via the object we called the overrided method of Interface
            // hence defined and passed as a callbeck function
            CallBackClass.funToCallBack(name, object : CallBackInterface{
                override fun printHello() {
                    //TODO("Not yet implemented")
                    print("Here the call of the CallBack Function \n")
                    print("Called: $name")
                }
            });


            var toPrintLambda: () -> Unit = {
                print("hi I'm LAMBDA\n")
            }
            var toPrintLambdawithArgument: (name: String) -> Unit = {name ->
                print("LAMBDA Argument: ")
                print(name)
            }

            /* calling of the LAMBDA */

            //CallBackClass.funToLambda(true,toPrintLambda,toPrintLambdawithArgument)

            // When calling the function, in it's arguments are the definition of the LAMBDAS
            CallBackClass.funToLambda(true,{
                print("hi I'm LAMBDA")
            },{
                    param : String ->
                print("LAMBDA Argument: ")
                print(param)
            })

        }

    }


}


// CallBacks
class CallBackClass {
    companion object{
        fun funToCallBack(text : String, callback: Main.CallBackInterface){
            Timer().schedule(300){
                callback.printHello()
            }
        }

        fun funToLambda(flag : Boolean, toPrintLambda: () -> Unit,
                        toPrintLambdawithArgument: (param : String) -> Unit){
            // In this definition of the funciton the LAMBDA functions are called
            // when this main function is called above, there the LAMBDA functions are defined
            if(flag) {
                // THE CALL OF THE LAMBDA FUNCTIONS
                toPrintLambda()
                toPrintLambdawithArgument(Main.name)
            }
        }
    }
}