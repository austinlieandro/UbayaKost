<?php
$array1 = array(
    'id' => 1,
    'nameKost' => 'Kost Putri Ubaya',
    'alamat' => 'Jl. Tenggilis Mejoyo Blk. AN No.26',
    'description' => 'Kost putri Dekat Ubaya Yang terjamin',
    'price' => 1000000,
    'imgUrl' => 'https://cdn-2.tstatic.net/bogor/foto/bank/images2/Lokasi-kejadian-pembuahan-di-kamar-kost-asri-lantai-tiga.jpg'
);

$array2 = array(
    'id' => 3,
    'nameKost' => 'Kost AH 21 Ubaya',
    'alamat' => 'Jl. Rungkut Mejoyo Utara I Blok AH No.21',
    'description' => 'Kost Dekat Ubaya yang dijamin murah dan kualitas terbaik',
    'price' => 1500000,
    'imgUrl' => 'https://cdn-2.tstatic.net/bogor/foto/bank/images/info-kosan.jpg'
);

echo json_encode(array($array1, $array2));
