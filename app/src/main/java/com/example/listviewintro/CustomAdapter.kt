package com.example.listviewintro

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class CustomAdapter(val listaElementi: ArrayList<Data>) : BaseAdapter() {
    override fun getCount() = listaElementi.size

    override fun getItem(position: Int) = listaElementi[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val context = parent?.context
        var rowView: View? = convertView
        var mediaPlayerGradimento : MediaPlayer? = null
        var mediaPlayerRifiuto : MediaPlayer? = null

        val inflater: LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        if (rowView == null)
            rowView = inflater.inflate(R.layout.elemento_lista, parent, false)

        val item = listaElementi[position]

        val immaginePaesaggio = rowView?.findViewById<ImageView>(R.id.imageViewImmagine)
        immaginePaesaggio?.setImageResource(item.immagine)

        val audioImageViewLike = rowView?.findViewById<ImageView>(R.id.imageViewLike)
        audioImageViewLike?.setOnClickListener {
            if (mediaPlayerGradimento == null)
                mediaPlayerGradimento = MediaPlayer.create(context, context.resources.getIdentifier(item.audioFileGradimento,"raw",context.packageName))
            mediaPlayerGradimento?.start()
        }

        val audioImageViewNotLike = rowView?.findViewById<ImageView>(R.id.imageViewNotLike)
        audioImageViewNotLike?.setOnClickListener {
            if (mediaPlayerRifiuto == null)
                mediaPlayerRifiuto = MediaPlayer.create(context, context.resources.getIdentifier(item.audioFileRifiuto,"raw",context.packageName))
            mediaPlayerRifiuto?.start()
        }

        return rowView!!
    }
}