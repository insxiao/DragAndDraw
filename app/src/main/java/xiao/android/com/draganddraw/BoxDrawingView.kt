package xiao.android.com.draganddraw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class BoxDrawingView(context: Context, attrs: AttributeSet?) : View(context, null) {
    val TAG: String = "BoxDrawingView"
    var boxes: MutableList<Box?> = arrayListOf()
    var currentBox: Box? = null
    val boxPaint: Paint = Paint()
    val backgroundPaint: Paint = Paint()

    constructor(context: Context) : this(context, null)

    init {
        boxPaint.color = 0xFF00FF00.toInt()

        backgroundPaint.color = 0x00000000.toInt()

    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawPaint(backgroundPaint)
        for (box in boxes) {
            val left: Float = Math.min(box!!.origin.x, box.current!!.x)
            val right: Float = Math.max(box.origin.x, box.current!!.x)
            val top: Float = Math.min(box.origin.y, box.current!!.y)
            val bottom: Float = Math.max(box.origin.y, box.current!!.y)
            canvas?.drawRect(left, top, right, bottom, boxPaint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val curr: PointF = PointF(event!!.x, event!!.y)

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                currentBox = Box(curr)
                boxes.add(currentBox)
            }
            MotionEvent.ACTION_MOVE -> {
                currentBox?.current = curr
                invalidate()
            }

            MotionEvent.ACTION_UP -> currentBox = null

            MotionEvent.ACTION_CANCEL -> currentBox = null
        }
        return true
    }
}