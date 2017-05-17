/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BE;

/**
 *
 * @author gudla
 */
public class GuildVolHours
{
    private int guildId;
    private int volId;
    private int hours;

    public GuildVolHours(int guildId, int volId, int hours)
      {
        this.guildId = guildId;
        this.volId = volId;
        this.hours =hours;
      }

    public int getGuildId()
      {
        return guildId;
      }

    public void setGuildId(int guildId)
      {
        this.guildId = guildId;
      }

    public int getVolId()
      {
        return volId;
      }

    public void setVolId(int volId)
      {
        this.volId = volId;
      }

    public int getHours()
      {
        return hours;
      }

    public void setHours(int hours)
      {
        this.hours = hours;
      }
    
}
