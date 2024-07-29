package stream_project;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Ödev : Ogrenci Yönetim sistemi Spring boot jpa postgresql
// veritabanına öğrencileri eklemek güncellemek silmek listemelek için gereken restcontroller yazılacak
// stream, map, reduce kullanarak bütün öğrencilerin not ortalaması
// sınıfı geçen öğrenci sayısı (not > 50)
public class Main {

	public static void main(String[] args) {

		// sonradan ArrayList olarak kullanabileceğiniz dizileri
		// wrapper tipiyle oluşturmalısınız
		Integer[] arr = { 4, 3, 7, 5, 6, 2, 9, 3, 7 };

		List<Integer> sayilar = Arrays.asList(arr);

		// outer loop
		for (Integer sayi : sayilar) {
			System.out.println(sayi);
		}

		// inner loop
		sayilar.forEach((Integer i) -> {
			System.out.println(i);
		});
		sayilar.forEach(i -> System.out.println(i));
		sayilar.forEach(System.out::println); // method reference

		System.out.println("===== ikiye tam bölünen sayılar ======");
		// outer loop
		for (Integer sayi : sayilar) {
			if (sayi % 2 == 0) {
				System.out.println(sayi);
			}
		}
		System.out.println("===== stream api ile ikiye tam bölünen sayılar ======");
		// bilgisayarın cpu içinde tek core çalışmasıyla
		sayilar.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()).forEach(System.out::println);
		// bilgisayardaki bütün cpu ve core ları kullanır
		sayilar.parallelStream().filter(x -> x % 2 == 0).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("===== stream api ve map ile tek sayıların karesi ======");
		// liste içindeki tek sayıları bulup karesini yazdıran fonk
		List<Integer> tekSayilarinKaresiListesi = sayilar
		.stream()
		.filter(x -> x % 2 == 1)
		.map(x -> x * x)
		.collect(Collectors.toList());
		
		
		System.out.println("===== ilk liste ======");
		sayilar.forEach(System.out::println);
		
		// liste içinde tekrar eden sayırı bul
		System.out.println("===== liste içinde tekrar eden sayılar ======");
		sayilar
		.stream()
		.filter(x -> Collections.frequency(sayilar, x) > 1)
		.distinct()
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
 System.out.println("===== liste içinde tekrar eden sayılar ======");
	long tekrarEdenSayilarınAdedi = sayilar
		.stream()
		.filter(x -> Collections.frequency(sayilar, x) > 1)
		.distinct().count();
		
		// stream api içindeki reduce fonksiyonu liste içindeki bütükn elemanları gezerken 
		// tek bir sonuç üretmek amacıyla kullanılır
		System.out.println("===== liste içindeki sayıların toplamı ======");
	    int toplam = sayilar.stream().reduce(0,(x,y) -> x + y);
	    System.out.println(toplam);
	    
	    System.out.println("===== liste içindeki sayıların çarpımı ======");
	    int carpim = sayilar.stream().reduce(1,(x,y) -> x * y);
	    System.out.println(carpim);
		
	    System.out.println("===== liste içindeki sayıların çarpımı ======");
	    
	    if(sayilar.size() > 1) {
	    	carpim = sayilar.stream().reduce((x,y) -> x * y).get();
		    System.out.println(carpim);
	    }
	    System.out.println("===== liste içindeki en büyük sayı ======");
	    // liste içindeki en büyük sayı
	    int enBuyukSayi = sayilar.stream().reduce(Integer.MIN_VALUE, (x , y) -> x > y ? x : y);
	    System.out.println(enBuyukSayi);
	    
	}

}
