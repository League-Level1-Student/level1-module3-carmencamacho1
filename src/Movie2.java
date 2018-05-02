
public class Movie2 {
public static void main(String[] args) {
	Movie fault = new Movie("The Fault in out Stars", 4);
	Movie panther = new Movie("Black Panther", 5);
	Movie dory = new Movie("Finding Dory", 3);
	Movie spray = new Movie("Hairspray", 4);
	Movie tales = new Movie("Veggie Tales", 1);
	String a = fault.getTicketPrice();

	NetflixQueue net = new NetflixQueue();
	net.addMovie(fault );
	net.addMovie(panther);
	net.addMovie(dory);
	net.addMovie(spray);
	net.addMovie(tales);
net.printMovies();
Movie b = net.getBestMovie();
System.out.println("The best movie is " + b);
Movie c = net.getMovie(2);
System.out.println("The second best movie is " + c);

	}
}
