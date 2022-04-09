package com.qdu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag implements Serializable {
    private int tagId;
    private String tagName;
    private int tagSex;
    private Date tagCreateTime;
    private Date tagModifyTime;
}
