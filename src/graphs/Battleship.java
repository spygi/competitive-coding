package graphs;

import java.util.Arrays;
import java.util.List;

public class Battleship {
    // size n, k ships of l masts
    static int[][] map = new int[10][10]; // 0 in a position means no ship

    // k * l
    public static boolean constructMap(Ship... ships) {
        int i = 1; // ship identifiers start at 1, 0 means no ship
        for (Ship s : ships) {
            for (int j = 0; j < s.x.length; j++) { // the length of the ship
                // TODO check validity of coordinates of each ship
                if (map[s.getCoordinates(j).get(0)][s.getCoordinates(j).get(1)] != 0) {
                    return false;
                }
                map[s.getCoordinates(j).get(0)][s.getCoordinates(j).get(1)] = i;
            }
            i++;
        }

        // TODO check number of ships i and their type
        return true;
    }

    // n^2
    public static boolean isValidFullMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int ship = map[i][j];
                if (ship != 0) {
                    try {
                        if (map[i - 1][j] != ship && map[i - 1][j] != 0 || map[i + 1][j] != ship && map[i + 1][j] != 0 || map[i][j - 1] != ship && map[i][j - 1] != 0 || map[i][j + 1] != ship && map[i][j + 1] != 0) {
                            return false;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        // nothing
                    }
                }
            }
        }
        return true;
    }

    // k * l
    public static boolean isValid(Ship... ships) {
        for (Ship ship : ships) {
            for (int j = 0; j < ship.x.length; j++) { // the length of the ship
                int x = ship.getCoordinates(j).get(0);
                int y = ship.getCoordinates(j).get(1);
                int shipId = map[x][y];
                if (shipId != 0) {
                    try {
                        if (map[x - 1][y] != shipId && map[x - 1][y] != 0 || map[x + 1][y] != shipId && map[x + 1][y] != 0 || map[x][y - 1] != shipId && map[x][y - 1] != 0 || map[x][y + 1] != shipId && map[x][y + 1] != 0) {
                            return false;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        // nothing
                    }
                }
            }
        }

        return true;
    }

    public static class Ship {
        public int[] x, y;

        public Ship(int[] x, int[] y) {
            this.x = x.clone();
            this.y = y.clone();
        }

        public List<Integer> getCoordinates(int i) {
            return Arrays.asList(x[i], y[i]);
        }
    }

    public static void main(String[] args) {
        Ship a = new Ship(new int[]{1, 2}, new int[]{1, 2});
        Ship b = new Ship(new int[]{2, 1}, new int[]{3, 3});

        System.out.println(constructMap(a, b) ? isValidFullMap() : false);
        System.out.println(constructMap(a, b) ? isValid(a, b) : false);
    }
}
