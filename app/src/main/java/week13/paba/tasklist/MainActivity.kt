package week13.paba.tasklist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var _nama : List<String>
    private lateinit var _deskripsi : List<String>
    private lateinit var _deadline : List<String>

    private var arTask = arrayListOf<task>()
    private lateinit var _rvTask : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        _rvTask = findViewById<RecyclerView>(R.id.rvTask)

        SiapkanData()
        TambahData()
        TampilkanData()
    }

    fun SiapkanData(){
        _nama = resources.getStringArray(R.array.namaTask).toList()
        _deskripsi = resources.getStringArray(R.array.deskripsiTask).toList()
        _deadline = resources.getStringArray(R.array.deadlineTask).toList()
    }

    fun TambahData(){
        arTask.clear()
        for (position in _nama.indices){
            val data= task(
                _nama[position],
                _deskripsi[position],
                _deadline[position]
            )
            arTask.add(data)
        }
    }

    fun TampilkanData(){
        _rvTask.layoutManager = LinearLayoutManager(this)

        val adapterTask = adapterRecView(arTask)
        _rvTask.adapter = adapterTask


    }
}