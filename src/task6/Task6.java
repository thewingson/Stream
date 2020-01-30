package task6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task6 {

    public static void main(String[] args) {

//        List<Double> numbers = Arrays.asList(1.0, 1.1, 1.4, 1.7, 1.4, 5.4, 9.9);
//
//        Map<Integer, Integer> histogram = numbers.stream().collect(toHistogram(1));
//
//        for (Map.Entry<Integer, Integer> h : histogram.entrySet()) {
//            System.out.println("(" + h.getKey() + ") " +": " + "(" + h.getValue() + ")");
//        }

//        final List<Integer> result = IntStream.of(1, 2, 3, 4, 3, 4, 5)
//                .boxed()
//                .collect(CustomCollector.unique());
//
//        System.out.println(result);

        List<Team> teams = new ArrayList<>();
        Team team1 = new Team(1L, "Manchester United");
        Team team2 = new Team(2L, "Manchester City");
        teams.add(team1);
        teams.add(team2);


        List<Player> players1 = new ArrayList<>();
        players1.add(new Player(1L, "Marcus", "Rashford", Short.valueOf("22"), Position.FORWARD, team1, Short.valueOf("95"), Mood.HIGH, Boolean.TRUE));
        players1.add(new Player(2L, "Anthony", "Martial", Short.valueOf("24"), Position.FORWARD, team1, Short.valueOf("80"), Mood.LOW, Boolean.TRUE));
        players1.add(new Player(3L, "Paul", "Pogba", Short.valueOf("24"), Position.MIDFIELDER, team1, Short.valueOf("100"), Mood.CHARGED, Boolean.TRUE));
        players1.add(new Player(4L, "Bruno", "Fernandes", Short.valueOf("26"), Position.MIDFIELDER, team1, Short.valueOf("100"), Mood.HIGH, Boolean.FALSE));
        players1.add(new Player(5L, "Harry", "Maguire", Short.valueOf("26"), Position.DEFENDER, team1, Short.valueOf("100"), Mood.CHARGED, Boolean.TRUE));
        players1.add(new Player(6L, "Viktor", "Lindelof", Short.valueOf("24"), Position.DEFENDER, team1, Short.valueOf("100"), Mood.HIGH, Boolean.TRUE));
        players1.add(new Player(6L, "David", "De Gea", Short.valueOf("29"), Position.GOALKEEPER, team1, Short.valueOf("100"), Mood.HIGH, Boolean.TRUE));
        players1.add(new Player(6L, "Sergio", "Romero", Short.valueOf("32"), Position.GOALKEEPER, team1, Short.valueOf("80"), Mood.MIDDLE, Boolean.TRUE));

        List<Player> players2 = new ArrayList<>();
        players2.add(new Player(1L, "Sergio", "Aguero", Short.valueOf("30"), Position.FORWARD, team2, Short.valueOf("100"), Mood.CHARGED, Boolean.TRUE));
        players2.add(new Player(2L, "Leroy", "Sane", Short.valueOf("22"), Position.FORWARD, team2, Short.valueOf("20"), Mood.DEPRESSED, Boolean.FALSE));
        players2.add(new Player(3L, "Kevin", "De Bruyne", Short.valueOf("26"), Position.MIDFIELDER, team2, Short.valueOf("100"), Mood.CHARGED, Boolean.TRUE));
        players2.add(new Player(4L, "David", "Silva", Short.valueOf("29"), Position.MIDFIELDER, team2, Short.valueOf("100"), Mood.HIGH, Boolean.TRUE));
        players2.add(new Player(5L, "Emerice", "Laporte", Short.valueOf("24"), Position.DEFENDER, team2, Short.valueOf("90"), Mood.HIGH, Boolean.TRUE));
        players2.add(new Player(6L, "Otamendi", "Otamendi", Short.valueOf("28"), Position.DEFENDER, team2, Short.valueOf("60"), Mood.MIDDLE, Boolean.TRUE));
        players2.add(new Player(6L, "Ederson", "Ederson", Short.valueOf("23"), Position.GOALKEEPER, team2, Short.valueOf("100"), Mood.HIGH, Boolean.TRUE));
        players2.add(new Player(6L, "Asd", "Asd", Short.valueOf("32"), Position.GOALKEEPER, team2, Short.valueOf("70"), Mood.MIDDLE, Boolean.TRUE));

        List<Player> result1 = players1.stream().collect(GameCollector.buildUp(5));

        for (Player p : result1) {
            System.out.println(p.getFirstName() + " " + p.getLastName());
        }

    }

}
