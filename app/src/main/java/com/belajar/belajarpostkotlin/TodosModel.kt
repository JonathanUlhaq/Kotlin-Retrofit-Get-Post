package com.belajar.belajarpostkotlin

data class TodosModel(val todos:List<Data>) {
    data class Data(val id:String?, val todo:String?)
}