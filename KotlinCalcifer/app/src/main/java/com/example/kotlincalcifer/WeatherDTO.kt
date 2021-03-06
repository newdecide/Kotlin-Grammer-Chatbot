package com.example.kotlincalcifer

data class WeatherDTO(
        var cod : String? = null,
        var message : Float? = null,
        var cnt : Int? = null,
        var list : MutableList<List>? = null
){
    data class List(
            var dt : Int? = null,
            var main : Main? = null,
            var weather : MutableList<Weather>? = null,
            var clouds : Clouds? = null,
            var wind : Wind? = null,
            var dt_txt : String? = null
    ){
        data class Main(
                var temp : Float? = null,
                var temp_min : Float? = null,
                var temp_max : Float? = null,
                var pressure : Float? = null,
                var sea_level : Float? = null,
                var grnd_level :Float? = null,
                var humidity : Float? = null,
                var temp_kf : Float? = null
        )
        data class Weather(
                var id : Int? = null,
                var main : String? = null,
                var description : String? = null,
                var icon : String? = null
        )
        data class Clouds(
                var all : Int? = null
        )
        data class Wind(
                var speed : Float? = null,
                var deg : Float? = null
        )
    }
}