/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.DAL;

import examproject2017.BE.Volunteer;

/**
 *
 * @author gudla
 */
public interface IVolLogHand
{

    Volunteer LoginChecker(String name);
    
}
