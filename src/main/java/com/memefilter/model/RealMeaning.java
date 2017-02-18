package com.memefilter.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;


/**
 * RealMeaning
 */

public class RealMeaning {


    private String memeText = null;


    private String reality = null;


    public RealMeaning memeText(String memeText) {
        this.memeText = memeText;
        return this;
    }


    /**
     * MemeText to be filtered.
     *
     * @return memeText
     **/

    @ApiModelProperty(value = "MemeText to be filtered.")
    public String getMemeText() {
        return memeText;
    }


    public void setMemeText(String memeText) {
        this.memeText = memeText;
    }


    public RealMeaning reality(String reality) {
        this.reality = reality;
        return this;
    }


    /**
     * Real meaning behind memeText.
     *
     * @return reality
     **/

    @ApiModelProperty(value = "Real meaning behind memeText.")
    public String getReality() {
        return reality;
    }


    public void setReality(String reality) {
        this.reality = reality;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RealMeaning realMeaning = (RealMeaning) o;
        return Objects.equals(this.memeText, realMeaning.memeText) &&
                Objects.equals(this.reality, realMeaning.reality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memeText, reality);
    }

    @Override
    public String toString() {

        return "class RealMeaning {\n" +
                "    memeText: " + toIndentedString(memeText) + "\n" +
                "    reality: " + toIndentedString(reality) + "\n" +
                "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

