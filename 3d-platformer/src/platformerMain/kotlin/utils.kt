import kotlin.math.PI

fun deg2rad(y: Float) = (y * PI / 180.0).toFloat()
fun rad2deg(y: Float) = (y * 180.0 / PI).toFloat()

fun Double.toRadians() = this * PI / 180.0
fun Float.toRadians() = (this * PI / 180.0).toFloat()

fun Double.toDegrees() = this * 180.0 / PI
fun Float.toDegrees() = (this * 180.0 / PI).toFloat()