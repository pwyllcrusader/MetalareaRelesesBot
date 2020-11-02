package by.pw.crr.metla.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class MetalareaRelease {

    @Id
    private Long id;
    private String bandName;
    private String albumTitle;
    private String albumYear;
    private String bandGenre;
    private String releaseLink;
    private boolean isSent;

    @Override
    public String toString() {
        return "*Artist: *" + bandName + "\n" +
                "*Album: *" + albumTitle + "\n" +
                "*Year: *" + albumYear + "\n" +
                "*Genre: *" + bandGenre + "\n" +
                "[link](" + releaseLink + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetalareaRelease that = (MetalareaRelease) o;
        return id.equals(that.id)
                && bandName.equals(that.bandName)
                && albumTitle.equals(that.albumTitle)
                && albumYear.equals(that.albumYear)
                && bandGenre.equals(that.bandGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bandName, albumTitle, albumYear, bandGenre);
    }
}
