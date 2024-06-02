package org.manzogi

fun main() {

    infix fun Char.higher(x:Char) : Boolean {
        return this < x
    }

    fun ArrayDeque<Char>.dump(s:StringBuilder) {
        while ( isEmpty().not() ) s.append(removeFirst())
    }

    val stack = ArrayDeque<Char>()

    val r = "a+b*c-d*e"
    var s = StringBuilder()

    if( r.isEmpty() ) return

    var index = 0

    while( index < r.length ) {

        when(r[index]) {

            '*' -> {
                stack.addFirst( r[index] )
            }

            '+','-' -> {
                if( stack.isEmpty().not() && stack.first() higher r[index] ) {
                    stack.dump(s)
                }
                stack.addFirst( r[index] )
            }

            else -> {
                s.append( r[index] )
            }

        }

        index++
    }
    stack.dump(s)

    r.also(::println)
    s.also(::println)

}