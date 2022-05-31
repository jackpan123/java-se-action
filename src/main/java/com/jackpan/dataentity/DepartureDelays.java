package com.jackpan.dataentity;

import lombok.Data;

/**
 * DepartureDelays操作类
 *
 * @author JackPan
 * @date 2022/05/30 15:16
 **/
@Data
public class DepartureDelays {

    private String date;

    private int delay;

    private int distance;

    private String origin;

    private String destination;

}
