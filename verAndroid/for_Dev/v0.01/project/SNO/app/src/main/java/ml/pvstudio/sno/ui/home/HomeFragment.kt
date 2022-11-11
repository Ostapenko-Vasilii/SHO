package ml.pvstudio.sno.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import ml.pvstudio.sno.databinding.FragmentHomeBinding
import ml.pvstudio.sno.fireBase.mainrv.MainRV
import ml.pvstudio.sno.fireBase.mainrv.MainRVAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var dbref : DatabaseReference
    private lateinit var themeRV : RecyclerView
    private lateinit var themeArrayList: ArrayList<MainRV>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        themeRV = binding.mainList
        themeRV.layoutManager = LinearLayoutManager(context)
        themeRV.setHasFixedSize(true)

        themeArrayList = arrayListOf<MainRV>()
        getThemeData()
       

        return root
    }
    fun qq(o : String) {

    }

    private fun getThemeData() {

        dbref = FirebaseDatabase.getInstance().getReference("MainRV")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){
                    for (themeSnapshot in snapshot.children){
                        val theme = themeSnapshot.getValue(MainRV::class.java)
                        themeArrayList.add(theme!!)
                    }
                 themeRV.adapter = MainRVAdapter(themeArrayList)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }
        )

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
