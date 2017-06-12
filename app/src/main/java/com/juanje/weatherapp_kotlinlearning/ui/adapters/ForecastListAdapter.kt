package com.juanje.weatherapp_kotlinlearning.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juanje.weatherapp_kotlinlearning.R
import com.juanje.weatherapp_kotlinlearning.domain.models.Forecast
import com.juanje.weatherapp_kotlinlearning.domain.models.ForecastList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*
import java.text.DateFormat
import java.util.*

class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)

        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount() = weekForecast.size

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(itemView.icon)
                itemView.date.text = convertDate(date)
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }

        private fun convertDate(date: Long): String {
            val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
            return df.format(date)
        }
    }
}
