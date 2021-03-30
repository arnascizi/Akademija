package lt.viko.eif.intelektika.pirmas

class Predicate(x: Int, y: Int) {

    private val x: Int = x
    private val y: Int = y

    fun getX(): Int {
        return x
    }

    fun getY(): Int {
        return y
    }

    override fun toString(): String {
        return "${getX()},${getY()}"
    }
}