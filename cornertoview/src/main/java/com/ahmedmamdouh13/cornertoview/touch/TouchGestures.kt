package com.ahmedmamdouh13.cornertoview.touch

interface TouchGestures {
    fun click()
    fun swipe(percent: Float)
    fun expand(id: Int)
    fun collapse(id: Int)
    fun scroll(
        percentTop: Float,
        percentBottom: Float,
        percentLeft: Float,
        percentRight: Float,
        id: Int
    )
}
