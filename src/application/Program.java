package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Numero do quarto: ");
		int number = sc.nextInt();
		System.out.println("Data de Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Data de Check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva, o check-out deve ser depois da data de check-in");
		} else {
			Reservation reserva = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println();
			System.out.println("Informe a data de atualização da reserva");
			System.out.println("Data de Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data de Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			String error = reserva.updateDates(checkIn, checkOut);
			if (error != null) { 
				System.out.println("Erro na reserva: " + error);				
			}else {
			System.out.println("Reservas: " + reserva);
			}
		}
	}

}
