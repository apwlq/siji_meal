package io.github.apwlq.schoolmealinfo

import io.github.apwlq.mealapi.NeisApi

val filter = "\\([^)]*\\)|[0-9]|&\\n".toRegex()
val customFilter = "공산|공산품|다선|하단|하단중|주찬|덕|하|대".toRegex()

fun getBreakfast(): String? {
    val neis = NeisApi.Builder().build()
    val schoolName = System.getenv("SCHOOL_NAME")
    val sch = neis.getSchoolByName(schoolName).first()
    val meal = neis.getMealsByDay(getNowDate(), sch.scCode, sch.schoolCode)
    return meal.breakfast?.joinToString("\n")?.replace(filter, "")?.replace(customFilter, "")?.replace(Regex("&(\r?\n|$)"), "$1")
}

fun getLunch(): String? {
    val neis = NeisApi.Builder().build()
    val schoolName = System.getenv("SCHOOL_NAME")
    val sch = neis.getSchoolByName(schoolName).first()
    val meal = neis.getMealsByDay(getNowDate(), sch.scCode, sch.schoolCode)
    return meal.lunch?.joinToString("\n")?.replace(filter, "")?.replace(customFilter, "")?.replace(Regex("&(\r?\n|$)"), "$1")
}

fun getDinner(): String? {
    val neis = NeisApi.Builder().build()
    val schoolName = System.getenv("SCHOOL_NAME")
    val sch = neis.getSchoolByName(schoolName).first()
    val meal = neis.getMealsByDay(getNowDate(), sch.scCode, sch.schoolCode)
    return meal.dinner?.joinToString("\n")?.replace(filter, "")?.replace(customFilter, "")?.replace(Regex("&(\r?\n|$)"), "$1")
}


fun getBreakfastKcal(): String? {
    val neis = NeisApi.Builder().build()
    val schoolName = System.getenv("SCHOOL_NAME")
    val sch = neis.getSchoolByName(schoolName).first()
    val meal = neis.getMealsByDay(getNowDate(), sch.scCode, sch.schoolCode, true)
    return meal.breakfast?.joinToString("\n")

}

fun getLunchKcal(): String? {
    val neis = NeisApi.Builder().build()
    val schoolName = System.getenv("SCHOOL_NAME")
    val sch = neis.getSchoolByName(schoolName).first()
    val meal = neis.getMealsByDay(getNowDate(), sch.scCode, sch.schoolCode, true)
    return meal.lunch?.joinToString("\n")
}

fun getDinnerKcal(): String? {
    val neis = NeisApi.Builder().build()
    val schoolName = System.getenv("SCHOOL_NAME")
    val sch = neis.getSchoolByName(schoolName).first()
    val meal = neis.getMealsByDay(getNowDate(), sch.scCode, sch.schoolCode, true)
    return meal.dinner?.joinToString("\n")
}