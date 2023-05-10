<?php
$array1 = array(
    'id' => 1,
    'nameKost' => 'Kost Putri AM 12 UBAYA',
    'price' => 2000000,
    'imgUrl' => 'https://berita.99.co/wp-content/uploads/2022/08/kost-gaya-kekinian.jpg',
    'statusPembayaran' => 'done'
);

$array2 = array(
    'id' => 2,
    'nameKost' => 'Kost Putri AN-9',
    'price' => 3000000,
    'imgUrl' => 'https://www.sewakost.com/files/06-2022/ad84870/terima-kost-estetik-672547591_large.jpg',
    'statusPembayaran' => 'done'
);

$array3 = array(
    'id' => 3,
    'nameKost' => 'Kost Putri AN-9',
    'price' => 6000000,
    'imgUrl' => 'https://www.sewakost.com/files/06-2022/ad84870/terima-kost-estetik-672547591_large.jpg',
    'statusPembayaran' => 'canceled'
);

$array4 = array(
    'id' => 4,
    'nameKost' => 'Kost Putri AM 12 UBAYA',
    'price' => 4000000,
    'imgUrl' => 'https://berita.99.co/wp-content/uploads/2022/08/kost-gaya-kekinian.jpg',
    'statusPembayaran' => 'pending'
);

echo json_encode(array($array1, $array2, $array3, $array4));
