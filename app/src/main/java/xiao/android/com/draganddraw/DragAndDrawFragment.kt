package xiao.android.com.draganddraw

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class DragAndDrawFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("BoxAndDrawing", "onCreateView")
        return inflater?.inflate(R.layout.fragment_drag_and_draw, container, false)

    }
}