package com.positive.chalenges.hackerrunk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by mykola.podolian on 6/23/17.
 */
public class GridlandMetro {

    private static class Track {
        long start;
        long end;

        Track(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        long rows = sc.nextLong();
        long columns = sc.nextLong();
        int tracks = sc.nextInt();
        Map<Long, List<Track>> tracksMap = collectTracksData(tracks, sc);
        System.out.println(rows * columns - calculateCellsOcupied(tracksMap));
    }

    private static Map<Long, List<Track>> collectTracksData(int tracksCount, Scanner sc){
        Map<Long, List<Track>> tracksMap = new HashMap<>();
        for (int i = 0 ; i < tracksCount; i ++) {
            long row = sc.nextLong();
            List<Track> tracks = tracksMap.computeIfAbsent(row, k -> new ArrayList<>());
            tracks.add(new Track(sc.nextLong(), sc.nextLong()));
        }
        return tracksMap;
    }

    private static long calculateCellsOcupied(Map<Long, List<Track>> tracksMap){
        long totalCellsOccupied = 0;
        for (long row : tracksMap.keySet()) {
            List<Track> tracks = tracksMap.get(row);
            tracks.sort((o1, o2) -> {
                if (o1 == null && o2 == null) {
                    return 0;
                } else if (o1 == null) {
                    return -1;
                } else if (o2 == null) {
                    return 1;
                } else {
                    return Long.compare(o1.start, o2.start);
                }
            });
            long cellsOccupied = 0;
            long start = 0;
            long end = -1;
            for (Track track : tracks) {
                if(track.start > end){
                    cellsOccupied += end - start + 1;
                    start = track.start;
                    end = track.end;
                } else if (track.end > end){
                    end = track.end;
                }
            }
            cellsOccupied += end - start + 1;
            totalCellsOccupied += cellsOccupied;
        }
        return totalCellsOccupied;
    }
}
