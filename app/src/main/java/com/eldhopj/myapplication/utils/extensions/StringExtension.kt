package com.eldhopj.myapplication.utils.extensions

import java.util.Locale

/**
 * Checks whether the user name is valid name or not.
 *
 * @return true-> if valid, else false
 */
fun String?.isLegalName(): Boolean = this != null &&
    this.trim().isNotEmpty() &&
    matches(Regex("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}"))

/**
 * Make String into Title case
 *
 *Eg: hello world -> Hello world
 */
fun String?.titleCase() = this?.toLowerCase(Locale.getDefault())?.capitalize(Locale.getDefault())
