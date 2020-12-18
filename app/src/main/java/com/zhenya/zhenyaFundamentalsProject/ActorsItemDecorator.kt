package com.zhenya.zhenyaFundamentalsProject

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ActorsItemDecorator(resources: Resources, val size: Int) : RecyclerView.ItemDecoration() {
    val margin = resources.getDimension(R.dimen.eight_dp_margin).toInt()
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.getChildAdapterPosition(view) != size - 1) {
            outRect.right = margin
        }
    }
}