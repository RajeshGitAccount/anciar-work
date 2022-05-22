package com.anciar.technologies

import com.anciar.technologies.main.model.SectionsModel

class AppRepository() {

    fun getRequiredInfo(): ArrayList<SectionsModel> {

        val completeArrayList: ArrayList<SectionsModel> = ArrayList()
        completeArrayList.add(
            SectionsModel(
                R.drawable.image_one,
                R.drawable.image_two,
                R.drawable.image_three,
                "Section 1"
            )
        )
        completeArrayList.add(
            SectionsModel(
                R.drawable.image_four,
                R.drawable.image_five,
                R.drawable.image_six,
                "Section 1"
            )
        )
        completeArrayList.add(
            SectionsModel(
                R.drawable.image_one,
                R.drawable.image_two,
                R.drawable.image_three,
                "Section 1"
            )
        )
        completeArrayList.add(
            SectionsModel(
                R.drawable.image_four,
                R.drawable.image_five,
                R.drawable.image_six,
                "Section 1"
            )
        )
        completeArrayList.add(
            SectionsModel(
                R.drawable.image_one,
                R.drawable.image_two,
                R.drawable.image_three,
                "Section 1"
            )
        )

        completeArrayList.add(
            SectionsModel(
                R.drawable.image_one,
                R.drawable.image_two,
                R.drawable.image_three,
                "Section 2"
            )
        )
        completeArrayList.add(
            SectionsModel(
                R.drawable.image_four,
                R.drawable.image_five,
                R.drawable.image_six,
                "Section 2"
            )
        )
        completeArrayList.add(
            SectionsModel(
                R.drawable.image_one,
                R.drawable.image_two,
                R.drawable.image_three,
                "Section 2"
            )
        )
        completeArrayList.add(
            SectionsModel(
                R.drawable.image_four,
                R.drawable.image_five,
                R.drawable.image_six,
                "Section 2"
            )
        )
        completeArrayList.add(
            SectionsModel(
                R.drawable.image_one,
                R.drawable.image_two,
                R.drawable.image_three,
                "Section 2"
            )
        )

        completeArrayList.add(
            SectionsModel(
                R.drawable.image_one,
                R.drawable.image_two,
                R.drawable.image_three,
                "Section 3"
            )
        )
        completeArrayList.add(
            SectionsModel(
                R.drawable.image_four,
                R.drawable.image_five,
                R.drawable.image_six,
                "Section 3"
            )
        )
        completeArrayList.add(
            SectionsModel(
                R.drawable.image_one,
                R.drawable.image_two,
                R.drawable.image_three,
                "Section 3"
            )
        )
        completeArrayList.add(
            SectionsModel(
                R.drawable.image_four,
                R.drawable.image_five,
                R.drawable.image_six,
                "Section 3"
            )
        )
        completeArrayList.add(
            SectionsModel(
                R.drawable.image_one,
                R.drawable.image_two,
                R.drawable.image_three,
                "Section 3"
            )
        )

        return completeArrayList

    }

}