package com.example.a160420079_utsanmp.model

data class Kost(
    val id: Int,
    val nameKost: String,
    val alamat: String,
    val description: String,
    val price: Int,
    val imgUrl: String
)

data class Profile(
    val id: Int,
    val username: String,
    val imgUrl: String
)

data class RiwayatKost(
    val id: Int,
    val nameKost: String,
    val alamat: String,
    val imgUrl: String,
    val durasi: Int
)

data class RiwayatTransaksi(
    val id: Int,
    val nameKost: String,
    val price: Int,
    val imgUrl: String,
    val statusPembayaran: String
)

data class Review(
    val id: Int,
    val username: String,
    val review: String,
    val imgUrl: String,
    val tanggal: String
)