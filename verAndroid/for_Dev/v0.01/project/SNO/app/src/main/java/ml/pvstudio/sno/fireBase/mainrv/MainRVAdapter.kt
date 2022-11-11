package ml.pvstudio.sno.fireBase.mainrv

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ml.pvstudio.sno.R
import ml.pvstudio.sno.databinding.RvMeinItemBinding

class MainRVAdapter(private val themeList: ArrayList<MainRV>) : RecyclerView.Adapter<MainRVAdapter.MainRVHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRVHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item,
        parent,false)
        return MainRVHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainRVHolder, position: Int) {

        val currentitem = themeList[position]
        holder.title.text = currentitem.title
        holder.title2.text = currentitem.title2
        if (currentitem.postImageBoolean == true && currentitem.postImage != null && currentitem.postImage != "") {
            holder.image.visibility = View.VISIBLE

            Glide.with(holder.itemView)
                .load("https://mirpozitiva.ru/wp-content/uploads/2019/11/1472042719_15.jpghttps://mirpozitiva.ru/wp-content/uploads/2019/11/1472042719_15.jpg")
                .into(holder.image)
            holder.title2.text = "test"
        } else { holder.image.visibility = View.GONE}
        Log.d("dataBase", "${currentitem.title}, ${currentitem.title2}")


    }

    override fun getItemCount(): Int {

        return themeList.size
    }


    class MainRVHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val image : ImageView = itemView.findViewById(R.id.imageRVMainView)
        val title2 : TextView = itemView.findViewById(R.id.tvfirstName)
        val title : TextView = itemView.findViewById(R.id.ffhjk)
    }


}
