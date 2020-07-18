package by.pw.crr.metla.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

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
    private boolean isHot;

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

        if (!bandName.equals(that.bandName)) return false;
        if (!albumTitle.equals(that.albumTitle)) return false;
        if (!albumYear.equals(that.albumYear)) return false;
        return bandGenre.equals(that.bandGenre);
    }

    @Override
    public int hashCode() {
        int result = bandName.hashCode();
        result = 42 * result + albumTitle.hashCode();
        result = 42 * result + albumYear.hashCode();
        result = 42 * result + bandGenre.hashCode();
        return result;
    }
}
