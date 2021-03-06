package ca.ualberta.cs.lonelytweet;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by alsobaie on 10/31/17.
 */

abstract class LonelyTweet implements Serializable {
    private static final long serialVersionUID = 1L;

    // changes access mode from protected to private (Declaration redundancy)
    protected Date tweetDate;
    protected String tweetBody;

    // changed access mode from private to protected (Declaration redundancy)
    protected Date getTweetDate() {
        return tweetDate;
    }

    public void setTweetDate(Date tweetDate) {
        this.tweetDate = tweetDate;
    }

    public abstract String getTweetBody();

    public void setTweetBody(String tweetBody) {
        this.tweetBody = tweetBody;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.writeObject(tweetDate);
        out.writeObject(tweetBody);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        tweetDate = (Date) in.readObject();
        tweetBody = (String) in.readObject();
    }

    public abstract boolean isValid();

    @Override
    public String toString() {
        return getTweetDate() + " | " + getTweetBody() ;
    }
}
