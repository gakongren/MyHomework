package cn.sorato.exp7;

/**
 * Created by kongren on 2016/11/15.
 */
public class Permission{
    public static final int
            SCORE_GET = 1,
            SCORE_ADD = 1 << 1,
            SCORE_SET = 1 << 2,
            SCORE_OVERWRITE = SCORE_GET | SCORE_ADD,
            SCORE_ALL = SCORE_OVERWRITE | SCORE_GET,

            PERMISSION_CHANGE = 1 << 3,
            ADMIN = SCORE_ALL | PERMISSION_CHANGE;
}
