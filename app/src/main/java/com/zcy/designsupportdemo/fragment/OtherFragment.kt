package com.zcy.designsupportdemo.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.zcy.designsupportdemo.R
import com.google.android.gms.plus.PlusOneButton


class OtherFragment : Fragment() {
    // The URL to +1.  Must be a valid URL.
    private val PLUS_ONE_URL = "http://developer.android.com"
    // TODO: Rename and change types of parameters
    //当一个引用可以为空时，定义时明确声明
    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_other, container, false)
    }

    override fun onResume() {
        super.onResume()
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    //伴生对象用来实现Java static的功能，可定义扩展函数和属性
    //此类中直接调用，其他类调用类似于static调用：OtherFragment.newInstance(...);
    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"
        // The request code must be 0 or greater.
        private val PLUS_ONE_REQUEST_CODE = 0

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OtherFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): OtherFragment {
            val fragment = OtherFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
