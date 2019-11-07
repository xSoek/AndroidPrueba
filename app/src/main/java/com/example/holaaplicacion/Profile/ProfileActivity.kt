package com.example.holaaplicacion.Profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.holaaplicacion.R
import kotlinx.android.synthetic.main.fragment_activity_profile.*


class ProfileActivity : Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

       return inflater.inflate(R.layout.fragment_activity_profile, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        nametxt.text = getString(R.string.Name)
        birthDatetxt.text =getString(R.string.birth_date2)
        citytxt.text = getString(R.string.birth_place2)
        colortxt.text = getString(R.string.color2)
        hobbytxt.text = getString(R.string.hobby2)
        profileImage.setImageResource(R.drawable.profileimg)
        descriptionText.text = getString(R.string.aboutMe)
    }
}
