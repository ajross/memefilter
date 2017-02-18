package com.memefilter.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;


/**
 * MemeText
 */

public class MemeText {

    private String memeText = null;

    public MemeText memeText(String memeText) {
        this.memeText = memeText;
        return this;
    }


    /**
     * The memeText of the meme.
     *
     * @return memeText
     **/

    @ApiModelProperty(value = "The memeText of the meme.")
    public String getMemeText() {
        return memeText;
    }


    public void setMemeText(String memeText) {
        this.memeText = memeText;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MemeText memeText = (MemeText) o;
        return Objects.equals(this.memeText, memeText.memeText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memeText);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MemeText {\n");

        sb.append("    memeText: ").append(toIndentedString(memeText)).append("\n");
        sb.append("}");
        return sb.toString();
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

