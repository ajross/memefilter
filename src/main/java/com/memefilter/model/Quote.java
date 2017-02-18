package com.memefilter.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;


/**
 * Quote
 */

public class Quote {

    private String quote = null;

    public Quote quote(String quote) {
        this.quote = quote;
        return this;
    }


    /**
     * The quote of the meme.
     *
     * @return quote
     **/

    @ApiModelProperty(value = "The quote of the meme.")
    public String getQuote() {
        return quote;
    }


    public void setQuote(String quote) {
        this.quote = quote;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Quote quote = (Quote) o;
        return Objects.equals(this.quote, quote.quote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quote);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Quote {\n");

        sb.append("    quote: ").append(toIndentedString(quote)).append("\n");
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

