package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.println("Numero do quarto: ");
			int number = sc.nextInt();
			System.out.println("Data de Check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Data de Check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reserva = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Informe a data de atualização da reserva");
			System.out.println("Data de Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data de Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reserva.updateDates(checkIn, checkOut);
			System.out.println("Reservas: " + reserva);
		} catch (ParseException e) {
			System.out.println("Formato de data invalida");
		} catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		} catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
	}

}
