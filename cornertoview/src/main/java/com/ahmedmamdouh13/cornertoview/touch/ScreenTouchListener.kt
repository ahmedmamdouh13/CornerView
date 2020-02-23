package com.ahmedmamdouh13.cornertoview.touch

import android.content.res.Resources
import android.view.MotionEvent
import android.view.View
import kotlin.math.max
import kotlin.math.min

class ScreenTouchListener   : View.OnTouchListener {
    private var percentTop: Float = 0.0f
    private var percentBottom: Float = 0.0f
    private var percentLeft: Float = 0.0f
    private var percentRight: Float = 0.0f
    private lateinit var gestures: TouchGestures
    var xPerPixel = 0f
    var yPerPixel = 0f
    var  xDifference = 0f
    var yDifference = 0f

    var isExpanded = false
   companion object {

       const val TOP_LIMIT = 0.4F
       const val BOTTM_LIMIT = 0.9F
       const val LEFT_LIMIT = 0.5F
       const val RIGHT_LIMIT = 0.8F
       val deviceHeight = Resources.getSystem().displayMetrics.heightPixels
       val deviceWidth = Resources.getSystem().displayMetrics.widthPixels

   }
    override fun onTouch(v: View, event: MotionEvent): Boolean {


        when(event.action){
            MotionEvent.ACTION_DOWN ->{
                println("Down x : ${event.x } , y : ${event.y}")
                xPerPixel = event.rawX
                yPerPixel = event.rawY
                 xDifference =  v.x - xPerPixel
                yDifference =  v.x - yPerPixel
            }

            MotionEvent.ACTION_MOVE ->{
               val  rawX = event.rawX
               val rawY= event.rawY


//                if (yPerPixel + rawX  < 1  && xPerPixel + rawY < 1)
                percentTop = max(0F, min(TOP_LIMIT, (yDifference + rawY) / deviceHeight)) / TOP_LIMIT
                percentBottom = max(0F, min(BOTTM_LIMIT, (yDifference + rawY) / deviceHeight)) / BOTTM_LIMIT
                percentLeft = max(0F, min(LEFT_LIMIT, (xDifference + rawX) / deviceWidth)) / LEFT_LIMIT
                percentRight = max(0F, min(RIGHT_LIMIT, (xDifference + rawX) / deviceWidth)) / RIGHT_LIMIT
                println("Move Top : ${percentTop} , Bottom : ${percentBottom}  Left ${percentLeft} , Right : ${percentRight}")
                if (percentTop < BOTTM_LIMIT)
                gestures.scroll(percentTop, percentBottom, percentTop * LEFT_LIMIT, percentRight,v.id)


            }
            MotionEvent.ACTION_UP ->{
//              isExpanded =  if (percentTop < 0.8) {
//                  gestures.expand()
//                  true
//              }
//                else {
//                  gestures.collapse()
//                  false
//              }
                println("Up yp : ${yPerPixel} , y : ${event.rawY}")

//                isExpanded = yDifference > 1


                if (yPerPixel >= event.rawY) {
                    gestures.expand(v.id)
                } else if (yPerPixel < event.rawY) {
                    gestures.collapse(v.id)
                }


            }
        }


        //v?.performClick()


        return true
    }


    fun setTouchGestures (gestures: TouchGestures){
        this.gestures = gestures
    }

}