package com.example.uas19090133.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas19090133.Adapter.AComment
import com.example.uas19090133.Adapter.APost
import com.example.uas19090133.R
import com.example.uas19090133.model.CreateRPost
import com.example.uas19090133.model.RComment
import com.example.uas19090133.model.RPost
import com.example.uas19090133.model.RetrofitClient
import kotlinx.android.synthetic.main.fragment_rekap.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RekapFragment: Fragment() {
    private val list = ArrayList<RPost>() //ini kosong
    private val listComment = ArrayList<RComment>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rekap, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showPosts()
//        createPosts()
//        showComments()
//        updatePosts() // perbedaan put dan patch, put merubah semuanya sesuai dengan inputkan(input 'null' akan berubah ke null), sdgkan pacth dapat menyesuaikan(input 'null' maka akan menggunakan value sebelumnya)
//        deletePost()
    }

    private fun deletePost() {
        RetrofitClient.instance.deletePosts(1).enqueue(object : Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                tv_ResponseCode.text = response.code().toString()
                //penasaran, mari kita manipulasi sendiri, gimana kalo misal tak ganti gini
//                if (response.code() == 200){
//                    tv_ResponseCode.text = "Berhasil Delete"
//                }
                //atau gini aja langsung
                tv_ResponseCode.text = "Berhasil"
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                tv_ResponseCode.text = t.message
            }

        })
    }

    private fun updatePosts() {
        RetrofitClient.instance.putPosts(
            5,
            4,
            5,
            null,  // title -> null karna yang ingin dirubah hanya text/body nya
            "Update text"
        ).enqueue(object : Callback<RPost>{
            override fun onResponse(call: Call<RPost>, response: Response<RPost>) {
                tv_ResponseCode.text = response.code().toString()
                val responeText = "Response Code : ${response.code()}\n" +
                        "Title : ${response.body()?.title}\n" + //body() -> untuk mengecek null atau tidak
                        "Body : ${response.body()?.text}\n" +
                        "userId : ${response.body()?.userId}\n" +
                        "id : ${response.body()?.id}"
                tv_ResponseCode.text = responeText
            }

            override fun onFailure(call: Call<RPost>, t: Throwable) {
                tv_ResponseCode.text = t.message
            }

        })
    }

    private fun showComments() {
        rv_Post.setHasFixedSize(true)
        rv_Post.layoutManager = LinearLayoutManager(activity)

        RetrofitClient.instance.getComments(2).enqueue(object :
            Callback<ArrayList<RComment>> {
            override fun onResponse(
                call: Call<ArrayList<RComment>>,
                response: Response<ArrayList<RComment>>
            ) {
                tv_ResponseCode.text = response.code().toString()
                response.body()?.let { listComment.addAll(it) }

                val adapter = AComment(listComment)
                rv_Post.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<RComment>>, t: Throwable) {
                tv_ResponseCode.text = t.message
            }

        })
    }

    private fun createPosts() {
        RetrofitClient.instance.createPost(
            19090133,
            "Helian Putri",
            "Project UAS Individu Mobile Programming - 5D"
        ).enqueue(object : Callback<CreateRPost> {
            override fun onResponse(
                call: Call<CreateRPost>,
                response: Response<CreateRPost>
            ) {
                //jika berhasil
                val responeText = "Response Code : ${response.code()}\n" +
                        "Title : ${response.body()?.title}\n" + //body() -> untuk mengecek null atau tidak
                        "Body : ${response.body()?.body}\n" +
                        "userId : ${response.body()?.userId}\n" +
                        "id : ${response.body()?.id}"
                tv_ResponseCode.text = responeText
            }

            override fun onFailure(call: Call<CreateRPost>, t: Throwable) {
                //set ketika ada error
                tv_ResponseCode.text = t.message
            }

        })
    }

    private fun showPosts() {
        //inisialisasi rv
        rv_Post.setHasFixedSize(true)
        //atur linear layout manager
        rv_Post.layoutManager = LinearLayoutManager(activity)

        //panggil retrofit client
        //utk callback pilih yang retrofit
        RetrofitClient.instance.getPost(2, 20).enqueue(object: Callback<ArrayList<RPost>> { //jika tanpa menggunakan manipulasi, param getPost harap dihapus
            override fun onResponse(
                call: Call<ArrayList<RPost>>,
                response: Response<ArrayList<RPost>>
            ) {
                //mengambil response code
                val responseCode = response.code().toString()
                //tampilkan di tv
                tv_ResponseCode.text = responseCode
                //tambahkan list dengan data dari retrofit
                response.body()?.let { list.addAll(it)}
                //inisialisasi adapter
                val adapter = APost(list)
                //set adapter rv dg adapter yg telah dibuat
                rv_Post.adapter = adapter
            }
            override fun onFailure(call: Call<ArrayList<RPost>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}