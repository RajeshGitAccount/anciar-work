package com.anciar.technologies.main


import android.graphics.Canvas
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.anciar.technologies.databinding.ItemDecoratorHeaderBinding
import kotlinx.android.synthetic.main.recycler_item_header.view.*


class SectionRecyclerItemDecoration(private val adapter: SectionRecyclerAdapter, val root: View) :
    RecyclerView.ItemDecoration() {

    lateinit var headerView: View

    init {
        initiateView()
    }

    private fun initiateView() {
        headerView = ItemDecoratorHeaderBinding.inflate(LayoutInflater.from(root.context)).root

    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        val topChild = parent.getChildAt(0)
        parent.getChildAdapterPosition(topChild)
            .let { topChildPosition ->
                val headerTitle = adapter.getSectionTitle(topChildPosition)
                headerView.rootView.title.text = headerTitle
            }
        topChild?.let {
            headerView.measure(
                View.MeasureSpec.makeMeasureSpec(topChild.width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(
                    View.MeasureSpec.UNSPECIFIED,
                    View.MeasureSpec.UNSPECIFIED
                )
            )
            headerView.layout(topChild.left, 0, topChild.right, headerView.measuredHeight)
        }
        headerView.draw(c)

    }
}