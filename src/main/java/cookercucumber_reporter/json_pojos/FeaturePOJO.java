package cookercucumber_reporter.json_pojos;

import com.google.gson.annotations.SerializedName;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Manjunath Prabhakar (Manjunath-PC)
 * @created 19/09/2020
 * @project cooker-cucumber-reporter
 *
 * <p> This POJO Class reads all the Tag's of JSON File</p>
 */
public class FeaturePOJO {

    @SerializedName(value = "line")
    private int line;

    @SerializedName(value = "elements")
    private List<Elements> elements = new ArrayList<Elements>();

    @SerializedName(value = "name")
    private String name = "";

    @SerializedName(value = "description")
    private String description = "";

    @SerializedName(value = "id")
    private String id = "";

    @SerializedName(value = "keyword")
    private String keyword = "";

    @SerializedName(value = "uri")
    private String uri = "";

    @SerializedName(value = "tags")
    private List<Tags> tags = new ArrayList<Tags>();

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public List<Elements> getElements() {
        return elements;
    }

    public void setElements(List<Elements> elements) {
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public Map<String, String> getFeaturesStatusesCount() {
        Map<String, String> stat = new HashMap<>();

        stat.put("pass", "" + elements.stream().filter(s -> s.getType().equalsIgnoreCase("scenario") & s.getStatus().equalsIgnoreCase("pass")).count());
        stat.put("fail", "" + elements.stream().filter(s -> s.getType().equalsIgnoreCase("scenario") & s.getStatus().equalsIgnoreCase("fail")).count());
        stat.put("skip", "" + elements.stream().filter(s -> s.getType().equalsIgnoreCase("scenario") & s.getStatus().equalsIgnoreCase("skip")).count());
        stat.put("other", "" + elements.stream().filter(s -> s.getType().equalsIgnoreCase("scenario") & s.getStatus().equalsIgnoreCase("other")).count());

        return stat;
    }

    public Duration getDuration() {
        Duration duration = Duration.ofSeconds(0);
        if (elements != null) {
            for (Elements scenario : elements) {
                duration = duration.plus(scenario.getDuration());
            }
        }
        return duration;
    }

    public String getStatus() {
        String res = "other";

        if (elements.stream().anyMatch(s -> s.getStatus().equalsIgnoreCase("fail"))) {
            res = "fail";
        } else if (elements.stream().anyMatch(s -> s.getStatus().equalsIgnoreCase("skip"))) {
            res = "skip";
        } else if (elements.stream().allMatch(s -> s.getStatus().equalsIgnoreCase("pass"))) {
            res = "pass";
        }

        return res;
    }

    public String getDurationStringFormat(Duration duration) {
        long da = duration.toDays();
        long h = duration.minusDays(da).toHours();
        long m = duration.minusHours(h).toMinutes();
        long s = duration.minusMinutes(m).getSeconds();
        long mi = duration.minusSeconds(s).getNano();

        String res =  ((da > 0 ? (da + "d") : "") + " " +
                (h > 0 ? (String.format("%02d", h) + "h") : "") + " " +
                (m > 0 ? (String.format("%02d", m) + "m") : "") + " " +
                (s > 0 ? (String.format("%02d", s) + "s") : "") + " " +
                (mi > 0 ? (("" + mi).substring(0, 3) + "ms") : "")).trim();

        return res.isEmpty() ? "0ms" : res;
    }



}
