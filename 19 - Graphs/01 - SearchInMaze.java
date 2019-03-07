/*
SEARCH A MAZE

Given a 2D array of 0s(blocked) and 1s(open) representing a maze with designated entrance and exit points,
find a path from the entrance to the exit, if one exists.
*/

import java.util.*;

class Solution {
    public List<Point> findPath(int[][] maze, Point src, Point dest) {
        List<Point> path = new ArrayList<>();
        Set<Point> visited = new HashSet<>();
        findPath(maze, src, dest, visited, path);
        return path;
    }

    private boolean findPath(int[][] maze, Point cur, Point dest, Set<Point> visited, List<Point> path) {
        if (cur.equals(dest)) {
            path.add(cur);
            return true;
        } else if (visited.contains(cur)) {
            return false;
        }

        visited.add(cur);
        path.add(cur);

        for (Point point : possibleNext(maze, cur)) {
            if (findPath(maze, point, dest, visited, path)) {
                return true;
            }
        }

        path.remove(cur);
        return false;
    }

    private List<Point> possibleNext(int[][] maze, Point cur) {
        List<Point> points = new ArrayList<>();
        if (cur.row + 1 < maze.length && maze[cur.row + 1][cur.col] == 1) {
            points.add(new Point(cur.row + 1, cur.col));
        }

        if (cur.row - 1 >= 0 && maze[cur.row - 1][cur.col] == 1) {
            points.add(new Point(cur.row - 1, cur.col));
        }

        if (cur.col + 1 < maze[0].length && maze[cur.row][cur.col + 1] == 1) {
            points.add(new Point(cur.row, cur.col + 1));
        }

        if (cur.col - 1 >= 0 && maze[cur.row][cur.col - 1] == 1) {
            points.add(new Point(cur.row, cur.col - 1));
        }

        return points;
    }
}

class Point {
    int row;
    int col;

    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.row, this.col);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point other = (Point) o;
        return this.row == other.row && this.col == other.col;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", this.row, this.col);
    }
}
