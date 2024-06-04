package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;


import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.Mock.*;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.ProfileDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.enums.LangEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.services.impl.ServicePlayerInterfaceImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.services.interfaces.ServicePlayerInterface;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.*;

import java.security.Provider;
import java.util.ArrayList;


public class ServiceJoueurImplTest {
  private ServicePlayerInterface servicePlayerImpl ;

  @BeforeEach
  void setUp(TestInfo testInfo) throws Exception {
    servicePlayerImpl = ServicePlayerInterfaceImpl.getInstance();
    ((ServicePlayerInterfaceImpl) servicePlayerImpl).clearProfiles();
    System.out.println("test " + testInfo.getDisplayName());
  }


  @Test
  void setPlayerValideTest(){
      //servicePlayerImpl = new PlayerOkMock();

      ProfileDTO profileAttendu = new ProfileDTO("baptiste", "bati", 2002, "manger, annoncer la pluie", "francais", new ArrayList<>());

      try{
        ProfileDTO profileResultat = servicePlayerImpl.createNewProfile("baptiste", "bati", 2002, "manger, annoncer la pluie", "francais", new ArrayList<>());
        assertEquals(profileAttendu, profileResultat, "création d'un profile avec un pseudo valide");

      }catch(Exception e){
        System.out.println(e);
      }



  }
  @Test
  void setPseudoPlayerVideTest(){
      //servicePlayerImpl = new PseudoPlayerVideMock();
      assertThrows(EmptyPseudoException.class, ()->{servicePlayerImpl.createNewProfile("baptiste", "", 2002, "manger, annoncer la pluie", "francais", new ArrayList<>());});

  }

  @Test
  void setPseudoPlayerNonUniqueTest() throws IllegalLangArgumentException, IllegalYearArgumentException, NonEmptyListException, NonUniquePseudoException, BadInterestsSeparatorException, EmptyInterestsException, EmptyPseudoException, EmptyNameException {


    //servicePlayerImpl = new PseudoPlayerNonUniqueMock();
    servicePlayerImpl.createNewProfile("lucas" , "bober kurwa", 2002, "explorateur, mangeur de cailloux", "francais", new ArrayList<>());
    assertThrows(NonUniquePseudoException.class, ()->{servicePlayerImpl.createNewProfile("baptiste", "bober kurwa", 2002, "manger, annoncer la pluie", "francais", new ArrayList<>());});
  }

  @Test
  void setNamePlayerVideTest(){
    //servicePlayerImpl = new NamePlayerVideMock();
    assertThrows(EmptyNameException.class, ()->{servicePlayerImpl.createNewProfile("", "bati", 2002, "manger, annoncer la pluie", "francais", new ArrayList<>());});

  }

  @Test
  void setInterestPlayerVideTest(){
    //servicePlayerImpl = new InterestsEmptyMock();
    assertThrows(EmptyInterestsException.class, ()->{servicePlayerImpl.createNewProfile("baptiste", "bati", 2002, "", "francais", new ArrayList<>());});

  }


  @Test
  void setLangueNotEnumTest(){
      //servicePlayerImpl = new LanguageChoiceInvalidMock();

      assertThrows(IllegalLangArgumentException.class, ()->{
          servicePlayerImpl.createNewProfile("baptiste", "bati", 2002, "manger, annoncer la pluie", "bvfibdog", new ArrayList<>());});
  }


  void setBirthYearInvalidTest(){
    //servicePlayerImpl = new BirthYearInvalidMock();


      assertThrows(IllegalYearArgumentException.class, ()->{
        servicePlayerImpl.createNewProfile("baptiste", "bati", 1900, "manger, annoncer la pluie", "francais", new ArrayList<>());});
  }
}

