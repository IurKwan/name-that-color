package com.github.iurkwan.namethatcolor.core.util

import kotlin.math.roundToInt

fun Double.roundTo2Decimal() = (this * 100.0).roundToInt()
fun Double.roundTo2HexString() = "%02x".format((this).roundToInt())