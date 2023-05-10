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
    'id' => 2,
    'nameKost' => 'Kost Putri AM 12 UBAYA',
    'alamat' => 'Jl. Tenggilis Mejoyo Blok AM No.12',
    'description' => 'Kost putri Dekat Ubaya Yang terjamin dan aman',
    'price' => 2000000,
    'imgUrl' => 'https://berita.99.co/wp-content/uploads/2022/08/kost-gaya-kekinian.jpg'
);

$array3 = array(
    'id' => 3,
    'nameKost' => 'Kost AH 21 Ubaya',
    'alamat' => 'Jl. Rungkut Mejoyo Utara I Blok AH No.21',
    'description' => 'Kost Dekat Ubaya yang dijamin murah dan kualitas terbaik',
    'price' => 1500000,
    'imgUrl' => 'https://cdn-2.tstatic.net/bogor/foto/bank/images/info-kosan.jpg'
);

$array4 = array(
    'id' => 4,
    'nameKost' => 'Kost Putri AN-9',
    'alamat' => 'Jl. Tenggilis Mejoyo Blk. AN No.9 / No.36',
    'description' => 'Kost putri Paling Dekat Ubaya Yang terjamin',
    'price' => 3000000,
    'imgUrl' => 'https://www.sewakost.com/files/06-2022/ad84870/terima-kost-estetik-672547591_large.jpg'
);

echo json_encode(array($array1, $array2, $array3, $array4));
