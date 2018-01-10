package main.java.uniche.entities;

import com.badlogic.gdx.physics.box2d.*;
import main.java.uniche.GameScreen;
import main.java.uniche.utils.Skaalausta;

public class InvisLever {
    public Body lever;
    public String id;
    private GameScreen gs;
    public boolean isSetToClose = false;


    public InvisLever(World world, String id, float x, float y) {
        this.id = id;
        createLever(world, x, y);

    }

    //Luodaan näkymätön nappula jolla suljetaan ovet + kytketään stageComplete päälle sekä käytetään
    // stageComplete nappulan luomiseen. -Kalle
    private void createLever(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(x, y);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(28 / 2 / Skaalausta.Scaler, 28 / 2 / Skaalausta.Scaler);

        FixtureDef fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = 1.0f;
        fixture.isSensor = true;

        this.lever = world.createBody(bdef);
        this.lever.createFixture(fixture).setUserData(this);
    }

    //ContactHandler käyttää tätä -Kalle
    public void painettu() {
        System.out.println("DOOR CLOSING");
        isSetToClose = true;

    }
    //GETTERI jotta vaoidaan tarkastaa onko true/false -Kalle
    public boolean isSetToClose() {
        return isSetToClose;
    }
}


